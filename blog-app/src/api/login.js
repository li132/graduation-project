import request from '@/request'

export function login(account, password) {
  const data = {
    account,
    password
  }
  return request({
    url: '/login',
    method: 'post',
    data
  })
}

export function logout() {
  return request({
    url: '/logout',
    method: 'get'
  })
}

export function getUserInfo() {
  return request({
    url: '/users/currentUser',
    method: 'get'
  })
}

export function getUserInfoById(id) {
  return request({
    url: `/users/getUserById/${id}`,
    method: 'get'
  })
}

export function register(account, nickname, password) {
  const data = {
    account,
    nickname,
    password
  }
  return request({
    url: '/register',
    method: 'post',
    data
  })
}

export function getUserInfos(id) {
  return request({
    url: `/users/getUserInfos/${id}`,
    method: 'get'
  })
}

export function updateUserInfo(user, personInfo) {
  return request({
    url: '/users/updateUserInfo',
    method: 'get',
    params: {
      infoId:personInfo.infoId,
      userId:user.userId,
      position:personInfo.position,
      company:personInfo.company,
      profile:personInfo.profile,
      homepage:personInfo.homepage,
      id:user.userId,
      avatar:user.avatar,
      email:user.email,
      mobilePhoneNumber:user.mobilePhoneNumber,
      nickname:user.userName,
      password:user.password
    }
  })
}
