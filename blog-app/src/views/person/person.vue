<template>
  <div id="person">
    <div class="person-all">
      <div class="person-head">
        <div class="person-head-left">
            <div class="person-avatar"><img :src="user.avatar"/> </div>
            <div class="person-info">
                <div class="user-name"><font>{{user.name}}</font></div>
                <div class="user-info"><font>{{userInfo.company}}</font>|<font>{{userInfo.position}}</font><br/><font>{{userInfo.profile}}</font></div>
            </div>           
        </div>
        <div class="person-head-right">
            <el-button type="primary" @click="toPersonInfo(user.id)">修改个人信息</el-button>
        </div>
      </div>
      <div class="person-body">
          <el-tabs v-model="activeName" type="card" @tab-click="handleClick">
            <el-tab-pane label="专栏" name="first">
                <div class="article-all">
                    <article-scroll-page @articleCounts="getCount($event)" v-bind="article" v-if="this.article.title!=''"></article-scroll-page>
                    <div class="nothing" v-if="this.articlesLength<=0">nothing</div>
                </div>
            </el-tab-pane>
            <el-tab-pane label="点赞" name="second">
                <div class="like-all">
                    <article-scroll-page  @articleCounts="getCount($event)" v-bind="article" v-if="this.article.title!=''"></article-scroll-page>
                    <div class="nothing" v-if="this.articlesLength<=0">nothing</div>
                </div>
            </el-tab-pane>
            <el-tab-pane label="收藏集" name="third">
                <div class="collect-all">
                    <div class="collect-tag">
                        <div class="tag-left">收藏集</div>
                    </div>
                    <div>
                        <person-collect :userId="user.id" v-if="this.activeName='third'"></person-collect>
                    </div>
                </div>
            </el-tab-pane>
            <el-tab-pane label="关注" name="fourth">
                <div class="follow-all">
                    <div class="follow-tag">
                      <div class="follow-tag-left">关注</div>
                      <div class="follow-tag-right">
                        <a :class="isFollow?'choose':'nochoose'" @click="toAuthors()">关注了</a>|<a :class="!isFollow?'choose':'nochoose'" @click="toFollows()">关注者</a>
                      </div>
                    </div>
                    <div class="follow-body">
                      <div v-if="isFollow">
                        <div v-for="u in follows" :key="u"  class="follow-user">
                          <div>{{u.nickname}}</div>
                        </div>
                      </div>
                      <div v-if="!isFollow">
                        <div v-for="u in authors" :key="u" class="follow-user">
                          <div>{{u.nickname}}</div>
                        </div>
                      </div>
                      
                    </div>
                </div>
            </el-tab-pane>
          </el-tabs>
      </div>
    </div>
  </div>
</template>

<script>
import ArticleScrollPage from '@/views/common/ArticleScrollPage'
import Collect from '@/views/Collect';
import PersonCollect from '@/views/person/PersonCollect';
import { getUserInfos } from "@/api/login";
import { getFollow } from "@/api/article";
import { getauthors } from "@/api/article";

  export default {
    name:'person',
    data(){
        return{
          userInfo:{},
          articles:{},
          activeName:'first',
          articlesLength:0,
          article: {
            query: {
              tagId: '',
              categoryId: '',
              userId: '',
              authorId: this.$store.state.id
            },
            title:'专栏'
          },
          isFollow:true,
          follows:[],
          authors:[]
        }
    },
    computed: {
      user() {
        let login = this.$store.state.account.length != 0
        let avatar = this.$store.state.avatar
        let name = this.$store.state.name
        let id = this.$store.state.id
        return {
          login, avatar,name,id
        }
      }
    },
    created(){
        this.personInit()
    },
    methods:{
        personInit(){
            let that = this
            getUserInfos(this.$store.state.id).then(data=>{
                that.userInfo=data.data
                console.log(that.userInfo)
            }).catch(error => {
              if (error !== 'error') {
                that.$message({type: 'error', message: '获取用户信息失败!', showClose: true})
              }
            })
        },
        handleClick(tab, event) {
        if (tab.name=='first') {
            this.article.query.userId=''
            this.article.query.authorId=this.$store.state.id
            this.article.title = '专栏'
        } else if(tab.name=='second'){
            this.article.query.authorId=''
            this.article.query.userId=this.$store.state.id
            this.article.title = '点赞'
        }else if(tab.name=='fourth'){
            this.getFollows()
        }
      },
      getCount(data){
          this.articlesLength=data
      },
      getFollows(){
        let that = this
        getFollow(that.$store.state.id).then(data=>{
          console.log(data.data)
          that.follows=data.data
        }).catch(error => {
          if (error !== 'error') {
            that.$message({type: 'error', message: '关注加载失败!', showClose: true})
          }
        })
        getauthors(that.$store.state.id).then(data=>{
          that.authors=data.data
        }).catch(error => {
          if (error !== 'error') {
            that.$message({type: 'error', message: '关注者加载失败!', showClose: true})
          }
        })
      },
      toAuthors(){
        if (!this.isFollow) {
          this.isFollow = true
        }
      },
      toFollows(){
        if (this.isFollow) {
          this.isFollow = false
        }
      },
      toPersonInfo(id){
        this.$router.push({path: `/personInfo/${id}`})
      }
    },
    components: {
      ArticleScrollPage,
      'collect': Collect,
      'person-collect':PersonCollect
    }
  }
</script>
<style>

.person-all{
    width:1000px;
    background:#FFFFFF;
}
.person-head{
    padding:10px 20px;
}
.person-avatar{
    float:left;
}
.person-info{
    clear:left
}
.user-name{
    width:100px;
    margin:0px;
}
.follow-tag-left{
  float:left;
  color:#5FB878
}
.follow-tag-right{
  float:right
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
.follow-body{
  clear:both
  
}
.follow-user{
  height:40px;
  line-height:40px;
}
</style>