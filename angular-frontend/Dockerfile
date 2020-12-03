# base image
FROM node:14.3.0 as node
# set working directory
RUN mkdir /usr/src/app 
 
WORKDIR /usr/src/app
RUN npm install -g @angular/cli
COPY . .

