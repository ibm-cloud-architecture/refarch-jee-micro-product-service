### Overview

ProductSearchService is a microservice that redirects service requests from BFF layer to Legacy Backend Layer. This service is introduced to implement Strangler Pattern. Currently it only redirects the requests to EJB layer. In future it can be used to redirect requests to new implementations of services using new technologies e.g. nodejs and nosql

The ProductSearchService exposes the following interfaces

- /Product/?categoryId=xx
- /Product/{id}
- /Category
- /Category/id

<br />


### Configuration

One configuration parameter that this micro service requires is the IP address of the EJB services host. The EJB services host IP address is specified in the environment variables of this application. The environment variable goes as EJBServiceIP="<IP>"

<br />

### Build WAR using Maven

1. Ensure maven is installed
2. On command prompt, navigate to ProductSearchService project
3. Run "mvn clean package" command
4. ProductSearchService-0.1.war is created under ProductSearchService/target directory
5. Use this war file for deploying the ProductSearchService module on app server

<br>
### Security Configuration in server.xml
The backend services are secured with basic authentication. Hence the intermediate REST service layer also needs to be secured. Add the following Basic Registry in server.xml file

    <ldapRegistry baseDN="dc=purplecompute,dc=com" bindDN="cn=admin,dc=purplecompute,dc=com" bindPassword="{xor}Dz4sLChvLTs=" host="<ldap-server ip>" id="ldap" ignoreCase="true" ldapType="Custom" port="31252" realm="<ldap-server ip>:31252" searchTimeout="8m">
     
        <contextPool enabled="true" initialSize="1" maxSize="0" preferredSize="3" timeout="0s" waitTime="3000ms"/>
        
        <ldapCache>
            <attributesCache enabled="true" size="4000" sizeLimit="2000" timeout="1200s"/>
            <searchResultsCache enabled="true" resultsSizeLimit="1000" size="2000" timeout="600s"/>
        </ldapCache>
    
    </ldapRegistry>
