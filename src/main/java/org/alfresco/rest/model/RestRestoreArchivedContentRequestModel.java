package org.alfresco.rest.model;

import org.alfresco.rest.core.IRestModel;
import org.alfresco.rest.core.assertion.ModelAssertion;
import org.alfresco.utility.model.TestModel;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Generated by 'dedwards' on '2021-12-16 08:32' from 'Alfresco Content Services REST API' swagger file 
 * Generated from 'Alfresco Content Services REST API' swagger file
 * Base Path {@linkplain /alfresco/api/-default-/public/alfresco/versions/1}
 */
public class RestRestoreArchivedContentRequestModel extends TestModel implements IRestModel<RestRestoreArchivedContentRequestModel>
{
    @Override
    public ModelAssertion<RestRestoreArchivedContentRequestModel> assertThat()
    {
        return new ModelAssertion<RestRestoreArchivedContentRequestModel>(this);
    }

    @Override
    public ModelAssertion<RestRestoreArchivedContentRequestModel> and()
    {
        return assertThat();
    }

    @JsonProperty(value = "entry")
    RestRestoreArchivedContentRequestModel model;

    @Override
    public RestRestoreArchivedContentRequestModel onModel()
    {
        return model;
    }

    /**
    Restore from archive priority (Standard/High - to be mapped to Storage Provider specific values in Cloud Connectors)
    */	        

    private String restorePriority;	    

    public String getRestorePriority()
    {
        return this.restorePriority;
    }

    public void setRestorePriority(String restorePriority)
    {
        this.restorePriority = restorePriority;
    }				
}
 
