### Overview

This is an intermediate REST interface module which redirects the REST requests to the Legacy Backend Layer. This intermediate layer is introduced so as to absorb any future changes to either the UI layer or the backend layer. 

The ProductSearchService exposes the following interfaces

- /Product/?categoryId=xx
- /Product/{id}
- /Category
- /Category/id

<br><br>
<b>Build WAR using Maven</b>

- Ensure maven is installed
- On command prompt, navigate to ProductSearchService project
- Run "mvn clean package" command
- ProductSearchService-0.1.war is created under ProductSearchService/target directory
- Use this war file for deploying the ProductSearchService module on app server

<br>
<b>Security Configuration in server.xml</b>
The backend services are secured with basic authentication. Hence the intermediate REST service layer also needs to be secured. Add the following Basic Registry in server.xml file

    <ldapRegistry baseDN="dc=purplecompute,dc=com" bindDN="cn=admin,dc=purplecompute,dc=com" bindPassword="{xor}Dz4sLChvLTs=" host="<ldap-server ip>" id="ldap" ignoreCase="true" ldapType="Custom" port="31252" realm="<ldap-server ip>:31252" searchTimeout="8m">
     
        <contextPool enabled="true" initialSize="1" maxSize="0" preferredSize="3" timeout="0s" waitTime="3000ms"/>
        
        <ldapCache>
            <attributesCache enabled="true" size="4000" sizeLimit="2000" timeout="1200s"/>
            <searchResultsCache enabled="true" resultsSizeLimit="1000" size="2000" timeout="600s"/>
        </ldapCache>
    
    </ldapRegistry>
