FROM tomcat:10.1.25-jre17
RUN rm -rf /usr/local/tomcat/webapps/*
COPY ./target/interview-0.0.1-SNAPSHOT.war /usr/local/tomcat/webapps/ROOT.war
CMD ["catalina.sh","run"]