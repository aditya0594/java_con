package SeleniumTopic;

public class jenkins {

    /**

      To start the jeinkins : java -jar jenkins.war
     start on this port : http://localhost:8080

     To start on the different port : java -jar jenkins.war --httpPort=9090


     Cron job timing format is :
     5 → Minute (i.e., 5 minutes past)
     14 → Hour (24-hour format → 2 PM)
     * * * → Every day, every month, every day of the week

     Great question! In Jenkins cron syntax, the H stands for
     "Hash" — it's a special feature that Jenkins adds to standard cron to help spread out job executions
     and avoid overloading the system at specific times.
     H lets Jenkins pick a consistent but spread-out value based on the job name.
     For example, if two jobs both have H 14 * * *,
     they’ll run at different minutes past 2 PM (like 2:07 PM and 2:41 PM), depending on their names.
     This ensures load balancing across Jenkins jobs.


     What is Jenkins?

     Answer: Jenkins is an open-source automation server that facilitates continuous integration and continuous delivery (CI/CD)
     by automating the building, testing, and deployment of software projects


     What are Jenkins agents, and how do they contribute to distributed builds?

     Answer: Jenkins agents are secondary machines that run build jobs,
     allowing Jenkins to distribute workloads across multiple systems, thereby improving build performance and scalability



     How can Jenkins integrate with Docker?

     Answer: Jenkins can build and publish Docker images, run builds inside Docker containers,
     and use Docker agents to create consistent build environments.


     What is the purpose of the 'Jenkinsfile'?

     Answer: A 'Jenkinsfile' is a text file that contains
     the definition of a Jenkins Pipeline and is checked into source control, enabling pipeline as code.



     What are the steps to configure a Jenkins job for running automated tests?

     Answer: To configure a Jenkins job for automated tests:
     Create a new job and link it to the version control repository.
     Define build triggers (e.g., upon code commits).
     Specify the build steps to compile the code and execute test scripts.
     Configure post-build actions to publish test results and send notifications.




     What plugins are essential for integrating automated tests in Jenkins?

     Answer: Key plugins include:
     JUnit Plugin: For publishing test results.
     TestNG Results Plugin: To integrate TestNG test reports.
     HTML Publisher Plugin: For displaying custom test reports.
     Email Extension Plugin: To send customized email notifications based on test outcomes.


     How do you handle test result reporting in Jenkins?

     Answer: Configure post-build actions to publish test reports using appropriate plugins. Ensure test report files are generated
     in a format recognized by Jenkins (e.g., JUnit XML) and specify the report paths in the job configuration.




     How can Jenkins be used to run tests in parallel, and what are the benefits?

     Answer: Jenkins can run tests in parallel by:
     Configuring multiple agents to execute different test suites simultaneously.
     Using the 'Parallel Test Executor' plugin to split tests across agents.
     Parallel execution reduces overall test execution time and accelerates feedback.

     */
}
