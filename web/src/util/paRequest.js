import axios from 'axios'

const service = axios.create({
  baseURL: process.env.BASE_API,
  timeout: 5000,
  headers: {
    'Content-type': 'application/json;charset=UTF-8'
  }
})

export default service
