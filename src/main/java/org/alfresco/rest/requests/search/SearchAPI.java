/*
 * Copyright (C) 2017 Alfresco Software Limited.
 *
 * This file is part of Alfresco
 *
 * Alfresco is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Alfresco is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with Alfresco. If not, see <http://www.gnu.org/licenses/>.
 */
package org.alfresco.rest.requests.search;

import com.fasterxml.jackson.core.JsonProcessingException;

import org.alfresco.rest.core.RestRequest;
import org.alfresco.rest.core.RestWrapper;
import org.alfresco.rest.exception.ModelToJsonConversionException;
import org.alfresco.rest.requests.ModelRequest;
import org.alfresco.rest.search.SearchRequest;
import org.alfresco.rest.search.SearchResponse;
import org.springframework.http.HttpMethod;

import io.restassured.RestAssured;
/**
 * Wrapper for Search API.
 * @author Michael Suzuki
 *
 */
public class SearchAPI extends ModelRequest<SearchAPI>
{
    public SearchAPI(RestWrapper restWrapper)
    {
        super(restWrapper);
        RestAssured.basePath = "alfresco/api/-default-/public/search/versions/1";
        restWrapper.configureRequestSpec().setBasePath(RestAssured.basePath);
    }

    public SearchResponse search(SearchRequest queryBody)
    {
        RestRequest request;
        try
        {
            request = RestRequest.requestWithBody(HttpMethod.POST, queryBody.toJson(), "search");
        }
        catch (JsonProcessingException e)
        {
            throw new ModelToJsonConversionException(queryBody.getClass(), e);
        }
        return restWrapper.processModels(SearchResponse.class, request);
    }
}
