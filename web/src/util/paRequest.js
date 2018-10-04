import axios from 'axios'

const service = axios.create({
  baseURL: process.env.BASE_API,
  timeout: 5000,
  headers: {
    'Content-type': 'application/json;charset=UTF-8'
  }
})

// respone拦截器
service.interceptors.response.use(
  response => {
    return response.data
  },
  error => {
    console.log('err' + error)// for debug
    return Promise.reject(error)
  }
)

export default service
