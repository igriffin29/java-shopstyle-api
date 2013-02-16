package com.popsugar.shopping.api;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.popsugar.shopping.bo.Category;
import com.popsugar.shopping.bo.Product;

public class PopSugarShopping
{

    /**
     * Default version of the API end point
     */
    public static final int DEFAULT_VERSION = 2;

    /**
     * Hostname for the POPSUGAR Shopping US end point
     */
    public static final String US_API_HOSTNAME = "api.shopstyle.com";

    /**
     * Hostname for the POPSUGAR Shopping UK end point
     */
    public static final String UK_API_HOSTNAME = "api.shopstyle.co.uk";

    /**
     * Hostname for the POPSUGAR Shopping Germany end point
     */
    public static final String DE_API_HOSTNAME = "api.shopstyle.de";

    /**
     * Hostname for the POPSUGAR Shopping France end point
     */
    public static final String FR_API_HOSTNAME = "api.shopstyle.fr";

    /**
     * Hostname for the POPSUGAR Shopping Japan end point
     */
    public static final String JP_API_HOSTNAME = "api.shopstyle.co.jp";

    /**
     * Hostname for the POPSUGAR Shopping Australia end point
     */
    public static final String AU_API_HOSTNAME = "api.shopstyle.com.au";

    /**
     * Hostname for the POPSUGAR Shopping Canada end point
     */
    public static final String CA_API_HOSTNAME = "api.shopstyle.ca";
    
    private final String scheme = "http";
    private final String host;
    private final int port = 80;
    private final String pathPrefix;
    private final String partnerId;
    
    private HttpClient httpClient;
    private ObjectMapper mapper;

    public PopSugarShopping(String partnerId)
    {
        this(partnerId, US_API_HOSTNAME, DEFAULT_VERSION);
    }

    public PopSugarShopping(String partnerId, String hostname)
    {
        this(partnerId, hostname, DEFAULT_VERSION);
    }

    public PopSugarShopping(String partnerId, String hostname, int version)
    {
        this.partnerId = partnerId;
        this.host = hostname;
        this.pathPrefix = "/api/v" + version;
        configure();
    }
    
    private void configure()
    {
        this.httpClient = new DefaultHttpClient();
        this.mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }
    
    public void close()
    {
        if (httpClient != null) {
            ClientConnectionManager connectionManager = httpClient.getConnectionManager();
            if (connectionManager != null) {
                connectionManager.shutdown();
            }
            httpClient = null;
        }
        if (mapper != null) {
            mapper = null;
        }
    }

    public Product getProduct(long productId) throws APIException
    {
        return call("/products/" + productId, null, Product.class);
    }
    
    public ProductSearchResponse getProducts(ProductQuery request) throws APIException
    {
        return getProducts(request, 0, 0, null);
    }

    public ProductSearchResponse getProducts(ProductQuery request, int offset, int limit) throws APIException
    {
        return getProducts(request, offset, limit, null);
    }

    public ProductSearchResponse getProducts(ProductQuery query, int offset, int limit, ProductSort sort) throws APIException
    {
        List<NameValuePair> parameters = new ArrayList<NameValuePair>();
        if (offset > 0) {
            parameters.add(new BasicNameValuePair("offset", String.valueOf(offset)));
        }
        if (limit > 0) {
            parameters.add(new BasicNameValuePair("limit", String.valueOf(limit)));
        }
        if (sort != null && sort != ProductSort.Relevance) {
            parameters.add(new BasicNameValuePair("sort", sort.name()));
        }
        query.addParameters(parameters);
        return call("/products", parameters, ProductSearchResponse.class);
    }
    
    public ProductHistogramResponse getProductsHistogram(ProductQuery query, Class... filters) throws APIException
    {
        List<NameValuePair> parameters = new ArrayList<NameValuePair>();
        StringBuilder filtersString = new StringBuilder();
        for (Class filter : filters) {
            if (filtersString.length() > 0) {
                filtersString.append(',');
            }
            filtersString.append(filter.getSimpleName());
        }
        parameters.add(new BasicNameValuePair("filters", filtersString.toString()));
        query.addParameters(parameters);
        return call("/products/histogram", parameters, ProductHistogramResponse.class);
    }
    
    public BrandListResponse getBrands() throws APIException
    {
        return call("/brands", null, BrandListResponse.class);
    }
    
    public CategoryListResponse getCategories(Category root, int depth) throws APIException
    {
        return getCategories(root == null ? null : root.getId(), depth);
    }

    public CategoryListResponse getCategories(String rootId, int depth) throws APIException
    {
        List<NameValuePair> parameters = new ArrayList<NameValuePair>();
        if (rootId != null) {
            parameters.add(new BasicNameValuePair("cat", rootId));
        }
        if (depth > 0) {
            parameters.add(new BasicNameValuePair("depth", String.valueOf(depth)));
        }
        return call("/categories", parameters, CategoryListResponse.class);
    }
        
    public ColorListResponse getColors() throws APIException
    {
        return call("/colors", null, ColorListResponse.class);
    }
    
    public RetailerListResponse getRetailers() throws APIException
    {
        return call("/retailers", null, RetailerListResponse.class);
    }

    private <T> T call(String requestPath, List<NameValuePair> parameters, Class<T> responseType) throws APIException
    {
        if (httpClient == null) {
            throw new IllegalStateException("Client was closed");
        }
        URIBuilder uriBuilder = new URIBuilder();
        uriBuilder.setScheme(scheme).setHost(host).setPort(port);
        uriBuilder.setPath(pathPrefix + requestPath);
        uriBuilder.addParameter("pid", partnerId);
        if (parameters != null && !parameters.isEmpty()) {
            for (NameValuePair parameter : parameters) {
                uriBuilder.addParameter(parameter.getName(), parameter.getValue());
            }
        }
        URI uri;
        try {
            uri = uriBuilder.build();
        }
        catch (URISyntaxException e) {
            // unlikely to happen
            throw new APIException("Error while building URI", e);
        }
        
        HttpGet get = new HttpGet(uri);
        HttpResponse response;
        try {
            response = httpClient.execute(get);
        }
        catch (Exception e) {
            throw new APIException("Error while executing call to " + uri, e);
        }
        try {
            if (response.getStatusLine().getStatusCode() != 200) {
                // handle the error case
                HttpEntity errorResponse = response.getEntity();
                JsonNode errorDescription = mapper.readTree(errorResponse.getContent());
                JsonNode errorMessage = errorDescription.get("errorMessage");
                if (errorMessage == null || errorMessage.isNull()) {
                    throw new APIException("Undescribed error: " + errorDescription);
                }
                else {
                    throw new APIException(errorMessage.asText());
                }
            }
            else {
                // handle successful response
                HttpEntity successResponse = response.getEntity();
                return mapper.readValue(successResponse.getContent(), responseType);
            }
        }
        catch (APIException e) {
            // pass through
            throw e;
        }
        catch (Exception e) {
            throw new APIException("Error while processing response", e);
        }
        finally {
            get.releaseConnection();
        }
    }

    
    @SuppressWarnings("serial")
    public static class APIException extends Exception
    {
        public APIException(String message)
        {
            super(message);
        }

        public APIException(String message, Throwable cause)
        {
            super(message, cause);
        }
    }
}
