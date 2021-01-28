FROM ubuntu

RUN apt-get update -y
RUN apt-get install -y sudo

#get java
RUN sudo apt install -y openjdk-8-jdk

RUN sudo apt-get install -y wget
RUN sudo apt-get install -y unzip
RUN sudo apt-get install -y curl


ENV SBT_VERSION 1.1.5
ENV PROJECT_HOME /usr/src

#database variables
ENV DB_URL "jdbc:mysql://localhost:3306/femr_db?characterEncoding=UTF-8&useSSL=false"
ENV DB_USER "username"
ENV DB_PASS "password"

RUN mkdir -p $PROJECT_HOME/activator $PROJECT_HOME/app

WORKDIR $PROJECT_WORKPLACE/activator

RUN curl -O http://downloads.typesafe.com/typesafe-activator/1.3.6/typesafe-activator-1.3.6.zip 
RUN unzip typesafe-activator-1.3.6.zip -d / && rm typesafe-activator-1.3.6.zip && ls && sudo chmod a+x /activator-dist-1.3.6/activator
ENV PATH $PATH:/activator-1.3.6

# Install curl
RUN \
  apt-get update && \
  apt-get -y install curl

# Install sbt
RUN \
  curl -L -o sbt-$SBT_VERSION.deb https://dl.bintray.com/sbt/debian/sbt-$SBT_VERSION.deb && \
  dpkg -i sbt-$SBT_VERSION.deb && \
  rm sbt-$SBT_VERSION.deb && \
  apt-get update && \
  apt-get install sbt

ENV PATH $PROJECT_HOME/activator/activator-dist-1.3.10/bin:$PATH
ENV PATH $PROJECT_WORKPLACE/build/target/universal/stage/bin:$PATH
COPY . $PROJECT_HOME/app
WORKDIR $PROJECT_HOME/app
EXPOSE 9000

ENTRYPOINT url=$DB_URL usr=$DB_USER pass=$DB_PASS sbt ~run