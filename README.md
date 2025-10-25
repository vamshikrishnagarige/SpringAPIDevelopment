Download the project, unzip it and open it in your IDE.
The prerequisite is to have the Postgres Database installed on your machine.

Install Lombok plugin on your IDE to ensure the lombok annotations work as expected.
1. In IntelliJ Idea, Go to File -> Settings -> Plugins -> Marketplace -> Lombok plugin -> Install.
2. Post installation, Go to File -> Settings -> Build, Execution, Deployment -> Compiler -> Annotation Processors -> Enable "Enable annotation processing"

The above 2nd step will ensure all the lombok annotations work as expected. This setting is mainly for annotations like @AllArgsConstructor, @NoArgsConstructor, etc.

Edit the application.properties file with your database details and verify if the build is successful.
Once build is completed, try running the code and verify the API is working with the following paths:
1. /students
2. /students/{id}  -> {id} = [1, 2, 3,...]
