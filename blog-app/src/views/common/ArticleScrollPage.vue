<template>
  <scroll-page :loading="loading" :offset="offset" :no-data="noData" v-on:load="load">
    <div class="articleList-title">
      <div class="articles-left">{{title}}</div>
      <div class="articles-right">
        <a :class="this.hoter?'choose':'nochoose'" @click="theHot()">最热</a>|<a :class="!this.hoter?'choose':'nochoose'" @click="theNew()">最新</a>
      </div>
    </div>
    <article-item v-for="a in articles" :key="a.id" v-bind="a" class="articles-body"></article-item>
  </scroll-page>
</template>

<script>
  import ArticleItem from '@/components/article/ArticleItem'
  import ScrollPage from '@/components/scrollpage'
  import {getArticles} from '@/api/article'

  export default {
    name: "ArticleScrollPage",
    props: {
      offset: {
        type: Number,
        default: 100
      },
      page: {
        type: Object,
        default() {
          return {}
        }
      },
      query: {
        type: Object,
        default() {
          return {}
        }
      },
      title: {
        type: String,
        default: '文章'
      }
    },
    watch: {
      'query': {                                                                                                                                                                                                                                                                                                                                                                                                 
        handler() {
          this.noData = false
          this.articles = []
          this.innerPage.pageNumber = 1
          this.getArticles()
        },
        deep: true
      },
      'page': {
        handler() {
          this.noData = false
          this.articles = []
          this.innerPage = this.page
          this.getArticles()
        },
        deep: true
      },
      hoter:{
        handler() {
          this.noData = false
          this.articles = []
          this.innerPage.pageNumber = 1
          this.innerPage.pageSize = 5
          this.getArticles()
        }
      }
    },
    created() {
      this.getArticles()
    },
    data() {
      return {
        loading: false,
        noData: false,
        hoter:true,
        innerPage: {
          pageSize: 5,
          pageNumber: 1,
          name: 'a.viewCounts',
          sort: 'desc'
        },
        articles: []
      }
    },
    methods: {
      theHot(){
        if(!this.hoter){
          this.innerPage.name='a.viewCounts'
          this.hoter=true;         
        }
      },
      theNew(){
        if(this.hoter){
          this.innerPage.name='a.createDate'
          this.hoter=false;          
        }
      },
      load() {
        this.getArticles()
        
      },
      view(id) {
        this.$router.push({path: `/view/${id}`})
      },
      getArticles() {
        let that = this
        that.loading = true
        getArticles(that.query, that.innerPage).then(data => {

          let newArticles = data.data
          if (newArticles && newArticles.length > 0) {
            that.innerPage.pageNumber += 1
            that.articles = that.articles.concat(newArticles)
          } else {
            that.noData = true
          }          
          that.$emit("articleCounts",that.articles.length)    
        }).catch(error => {
          if (error !== 'error') {
            that.$message({type: 'error', message: '文章加载失败!', showClose: true})
          }
        }).finally(() => {
          that.loading = false
        })

      }
    },
    components: {
      'article-item': ArticleItem,
      'scroll-page': ScrollPage
    }

  }
</script>

<style scoped>
  .el-card {
    border-radius: 0;
  }

  .el-card:not(:first-child) {
    border-top:1px solid #A6A6A6;

  }
  .choose{
    color:#5FB878
  }
  .choose:link{
    color:#5FB878
  }
  .nochoose{
    color:#A6A6A6
  }
  .articleList-title{
    height:25px;
    padding:10px;
    line-height:25px;
    background:#FFFFFF
  }
  .articles-left{
    float:left;
    color:#5FB878
  }
  .articles-right{
    float:right
  }
  .articles-body{
    clear:both;
  }
</style>
