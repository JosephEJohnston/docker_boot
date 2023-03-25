FROM openjdk:17

# VOLUME 指定临时文件目录为 /tmp，在主机 /var/lib/docker 目录下创建一个临时文件并链接到容器的 /tmp
VOLUME /tmp

ADD docker_boot-0.0.1-SNAPSHOT.jar noob_docker.jar

RUN bash -c 'touch /noob_docker.jar'
ENTRYPOINT ["java", "-jar", "/noob_docker.jar"]

EXPOSE 6001

# docker build -t noob_docker:1.6 .

