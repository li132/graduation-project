<template>
    <div class="se-body" v-title :data-title="title">
    <el-container class="se-container">
      <div class="se-main">
      <div class="se-condition">
        <div class="se-condition-left">
          <ul class="condition-left">
            <li><a @click="change(1)" v-bind:class="{select:query.searchType=='all'}">综合</a></li>
            <li><a @click="change(2)" v-bind:class="{select:query.searchType=='article'}">文章</a></li>
            <li><a @click="change(3)" v-bind:class="{select:query.searchType=='tag'}">标签</a></li>
            <li><a @click="change(4)" v-bind:class="{select:query.searchType=='user'}">用户</a></li>
          </ul>
        </div>
        <div class="se-condition-right">
          <ul class="condition-right">
            <li><a @click="change(5)" v-bind:class="{select:query.days==0}">全部</a></li>
            <li><a @click="change(6)" v-bind:class="{select:query.days==1}">一天内</a></li>
            <li><a @click="change(7)" v-bind:class="{select:query.days==7}">一周内</a></li>
            <li><a @click="change(8)" v-bind:class="{select:query.days==30}">一月内</a></li>
          </ul>
        </div>
      </div>
      <div class="se-show">
        <div class="se-users" v-if="query.searchType=='user' && users && users.length>0">
          user
        </div>
        <div class="se-tags" v-if="tags && tags.length>0 &&(query.searchType=='all' || query.searchType=='tag')">
          <div class="se-tag"  v-for="t in tags" :key="t">
          <a @click="tag(t.id)">
          <img class="se-picture" :src="t.avatar?t.avatar:defaultAvatar"/>
          {{t.tagname}}
          </a>
          </div>
        </div>
        <div class="se-articles" v-if="articles && articles.length>0 &&(query.searchType=='all' || query.searchType=='article')">
        <scroll-page :loading="loading" :offset="offset" :no-data="noData" v-on:load="load">                 
          <article-item  v-for="a in articles" :key="a.id" v-bind="a"></article-item>
        </scroll-page>
      </div>
      </div>     
    </div>
    </el-container>
    
  </div>
</template>

<script>
import {searchArticles} from '@/api/article'
import defaultAvatar from '@/assets/img/logo.png'
import ArticleScrollPage from '@/views/common/ArticleScrollPage'
import ArticleItem from '@/components/article/ArticleItem'
import ScrollPage from '@/components/scrollpage'


export default {
    name: 'BlogSearch',
    props: {
      offset: {
        type: Number,
        default: 100
      }
    },
    created(){
        this.Search()
    },
    mounted(){
      const that = this
      that.$watch('query',function () {
          that.noData = false
          that.articles = []
          that.users = []
          that.tags = []
          that.innerPage.pageNumber = 1
          that.Search()
      }, {deep: true})
    },

    computed:{
        title(){
            return '搜索'
        }
    },
    data(){
        return{
          defaultAvatar: defaultAvatar,
          loading: false,
          noData: false,
          innerPage: {
            pageSize: 5,
            pageNumber: 1,
            name: 'a.createDate',
            sort: 'desc'
          },
          articles:[],
          users:[],
          tags:[],
          query:{
            word:'',
            searchType:'all',
            days:0
          }           
        }
    },
    methods:{
      load() {
        this.Search()
      },
      Search(){
        let that = this
        that.loading = true
        this.query.word = this.$route.params.word
       
        searchArticles(that.query,that.innerPage).then(data => {
        let newArticles = data.data.articles


        that.users = data.data.users
        that.tags = data.data.tags
        if (newArticles && newArticles.length > 0) {
          that.innerPage.pageNumber += 1
          that.articles = that.articles.concat(newArticles)
        } else {
          that.noData = true
        }

      }).catch(error => {
        if (error !== 'error') {
          console.log(error)
          that.$message({type: 'error', message: '搜索加载失败!', showClose: true})
        }
      }).finally(() => {
        that.loading = false
      })
      },
      change(type){
        let that = this
        switch (type) {
          case 1:
            that.query.searchType='all'
            break;
          case 2:
            that.query.searchType='article'
            break;
          case 3:
            that.query.searchType='tag'
            break;
          case 4:
            that.query.searchType='user'
            break;
          case 5:
            that.query.days=0
            break;
          case 6:
            that.query.days=1
            break;
          case 7:
            that.query.days=7
            break;
          case 8:
            that.query.days=30
            break;

          default:
            break;
        }
      },
      tag(id){
        this.$router.push({path: `/tag/${id}`})
      }
    },
    components: {
      'article-item': ArticleItem,
      'scroll-page': ScrollPage
    }
    
    
}
</script>
<style scoped>
  .se-picture{
    width: 50px;
    height: 50px;
  }
  .se-tag{
    height:70px;
    padding:15px,10px,15px,10px;
    border-top:1px solid #ebeef5;
    line-height:70px;
  }
  .se-tags {     
    
    color: #000;
  }
  .se-main{
    width:100%;
  }
  .se-body {
    margin: 60px auto 140px;
    min-width: 100%;
  }
  .se-container{
    width:50%;
    margin: 60px auto 140px;
    background:#FFFFFF;
  }
  .se-articles{
    clear:both;
  }
  .se-condition{
    height:50px;
    font-size:14px;
    line-height: 30px;
  }
  .se-condition a:hover,a:active{
    color:#5FB878
  }
  .select{
    color:#5FB878
  }
  .se-condition-left ul,.se-condition-left ul li{
    list-style:none; /* 将默认的列表符号去掉 */
    padding:0; /* 将默认的内边距去掉 */
    margin:5px; /* 将默认的外边距去掉 */
    float: left; /* 往左浮动 */
    display: block;
  }
  .se-condition-right{
    float:right;
  }
  .se-condition-right ul,.se-condition-right ul li{
    padding:0; /* 将默认的内边距去掉 */
    margin:5px; /* 将默认的外边距去掉 */
    float: left; /* 往左浮动 */
    display: block;
  }
</style>