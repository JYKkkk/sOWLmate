FROM node:16.16.0-alpine
# RUN npm install -g http-server
WORKDIR /app
COPY package*.json ./
RUN npm install
COPY . .
RUN npm run build
EXPOSE 80
CMD [ "npm", "run", "serve" ]