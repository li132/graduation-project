import request from '@/request'


export function getArticles(query, page) {
  return request({
    url: '/articles',
    method: 'get',
    params: {
      pageNumber: page.pageNumber,
      pageSize: page.pageSize,
      name: page.name,
      sort: page.sort,
      year: query.year,
      month: query.month,
      tagId: query.tagId,
      categoryId: query.categoryId,
      userId:query.userId,
      authorId:query.authorId,
      collectId:query.collectId
    }
  })
}

export function searchArticles(query, page) {
  return request({
    url: '/articles/search',
    method: 'get',
    params: {
      pageNumber: page.pageNumber,
      pageSize: page.pageSize,
      name: page.name,
      sort: page.sort,
      word: query.word,
      searchType: query.searchType,
      days: query.days
    }
  })
}

export function getHotArtices() {
  return request({
    url: '/articles/hot',
    method: 'get'
  })
}

export function getNewArtices() {
  return request({
    url: '/articles/new',
    method: 'get'
  })
}

export function viewArticle(id) {
  return request({
    url: `/articles/view/${id}`,
    method: 'get'
  })
}

export function deleteCollect(id) {
  return request({
    url: `/articles/deleteCollect/${id}`,
    method: 'get'
  })
}

export function getArticlesByCategory(id) {
  return request({
    url: `/articles/category/${id}`,
    method: 'get'
  })
}

export function getArticlesByTag(id) {
  return request({
    url: `/articles/tag/${id}`,
    method: 'get'
  })
}


export function publishArticle(article) {
  return request({
    url: '/articles/publish',
    method: 'post',
    data: article
  })
}

export function listArchives() {
  return request({
    url: '/articles/listArchives',
    method: 'get'
  })
}

export function getArticleById(id) {
  return request({
    url: `/articles/${id}`,
    method: 'get'
  })
}

export function checkLike(id) {
  return request({
    url: `/articles/isLike/${id}`,
    method: 'get'
  })
}

export function addLike(id){
  return request({
    url:`/articles/addLike/${id}`,
    method:'get'
  })
}

export function cancelLike(id){
  return request({
    url:`/articles/cancelLike/${id}`,
    method:'get'
  })
}

export function checkCollect(id) {
  return request({
    url: `/articles/isCollect/${id}`,
    method: 'get'
  })
}

export function getCollect() {
  return request({
    url: `/articles/getCollects`,
    method: 'get'
  })
}

export function getOneCollect(id) {
  return request({
    url: `/articles/getCollect/${id}`,
    method: 'get'
  })
}

export function addCollect(id,articleId) {
  return request({
    url: `/articles/addCollect`,
    method: 'get',
    params:{
      collectId:id,
      articleId:articleId
    }
  })
}

export function cancelCollect(id,articleId) {
  return request({
    url: `/articles/cancelCollect`,
    method: 'get',
    params:{
      collectId:id,
      articleId:articleId
    }
  })
}

export function newCollects(title) {
  return request({
    url: `/articles/newCollects/${title}`,
    method: 'get'
  })
}

export function checkFollow(query) {
  return request({
    url: `/articles/checkFollow`,
    method: 'get',
    params:{
      userId:query.userId,
      authorId:query.authorId,
      tagId:query.tagId
    }
  })
}

export function doFollow(query) {
  return request({
    url: `/articles/doFollow`,
    method: 'get',
    params:{
      userId:query.userId,
      authorId:query.authorId,
      tagId:query.tagId
    }
  })
}

export function cancelFollow(query) {
  return request({
    url: `/articles/cancelFollow`,
    method: 'get',
    params:{
      userId:query.userId,
      authorId:query.authorId,
      tagId:query.tagId
    }
  })
}

export function getFollow(id) {
  return request({
    url: `/articles/getFollow/${id}`,
    method: 'get'
  })
}

export function getauthors(id) {
  return request({
    url: `/articles/getauthors/${id}`,
    method: 'get'
  })
}