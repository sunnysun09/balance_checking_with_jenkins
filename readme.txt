
This is the test project to verify the balance page data. The technologies used here are:
  Cucumber, Java, JUnit, Selenium WebDriver, Maven, Page Object Model, Git
 
Jenkins is set up locally to create a Maven project to run the test whenever a pull is triggered.
  
See how_to_setup.txt for the detail of set up Git/Github and Jenkins.

Two things noticed in the setup:

1. Added the following code in pom.xml so that TestBalanceRunner.java can be run as "Maven test":
 <build>
        <plugins>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-compiler-plugin</artifactId>
                <configuration>
                    <source>1.5</source>
                    <target>1.5</target>
                </configuration>
            </plugin>
        </plugins>
  </build>
  
2. Seems Maven only looks at Test* or *Test files to run the test, so have to rename the test runner file as TestBalanceRunner.java

