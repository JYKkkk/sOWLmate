FROM node

# install simple http server for serving static content
# RUN npm install -g http-server

# make the 'app' folder the current working directory
WORKDIR /app

# copy both 'package.json' and 'package-lock.json' (if available)
COPY package*.json ./

COPY . .
# install project dependencies
RUN npm install

# copy project files and folders to the current working directory (i.e. 'app' folder)
COPY . .

# build app for production with minification
# RUN npm run build

EXPOSE 8443
CMD [ "npm", "start", "--", "--ws_uri=ws://i7b308.p.ssafy.io:8888/kurento" ]