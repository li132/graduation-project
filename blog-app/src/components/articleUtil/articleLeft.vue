<template>
  
  <div class="article-left">
    <div class="article-left-icon" @click="likes()">
      <el-badge  :value="this.likecounts" :max="99" class="item" >
        <i :class="islike?'me-icon-dianzan':'me-icon-like'" ></i>
      </el-badge>
    </div>
    <div class="article-left-icon" @click="toComment()">
      <el-badge  :value="this.article.commentCounts" :max="10" class="item" >
        <i class="me-icon-comment" ></i>
      </el-badge>
    </div>
    <!-- <div class="article-left-icon" @click="openCollect()">
      <i :class="iscollect?'el-icon-star-on':'el-icon-star-off'"></i>     
    </div> -->
    <el-popover placement="right" title="收藏夹" width="250" trigger="manual" v-model="collectVisible">
      <collect :articleId="article.id" v-if="this.$store.state.account.length != 0"></collect>
      <i :class="iscollect?'el-icon-star-on':'el-icon-star-off'" slot="reference" @click="openCollect()"></i> 
    <!-- <el-button slot="reference" @click="openCollect()">手动激活</el-button> -->
    </el-popover>
    <!-- 弹窗 -->
    <el-dialog :visible.sync="loginVisible" center :append-to-body='true' :lock-scroll="false" width="360px">
    <login @closeLogin="closelg()" @toRegister="toRegisters($event)"></login>
  </el-dialog>
  <el-dialog :visible.sync="registerVisible" center :append-to-body='true' :lock-scroll="false" width="360px">
    <register @closeRegister="closere()" @toLogin="toLogins($event)"></register>
  </el-dialog>
  <!-- <el-dialog title="收藏夹" :visible.sync="collectVisible" center :append-to-body='true' :lock-scroll="false" width="360px">
    <collect :articleId="article.id" v-if="article.id!=''"></collect>
  </el-dialog> -->
  </div>
       
  
  
</template>

<script>
import store from '@/store'
import { checkLike } from '@/api/article';
import { addLike } from '@/api/article';
import { cancelLike } from '@/api/article';
import { checkCollect } from '@/api/article';
import {getToken} from '@/request/token';
import Login from '@/views/Login';
import Register from '@/views/Register';
import Collect from '@/views/Collect';

  export default {
    name:'articleLeft',
    props:{
        article: {
        type: Object,
        default() {
          return {}
        }
      }
    },
    data(){
      return{
        islike:false,
        iscollect:false,
        likecounts:this.article.loveCounts,
        loginVisible: false,
        registerVisible: false,
        collectVisible: false 
      }
    }, 

    created(){
      this.Getlikeandcollect()
    },

    methods:{
      toComment(){
        document.querySelector("#view-comment").scrollIntoView(true);
      },
      toRegisters(data){
        if (data) {
          this.registerVisible=true
          this.loginVisible=false
        }
      },
      toLogins(data){
        if (data) {
          this.registerVisible=false
          this.loginVisible=true
        }
      },
      closelg(){
        this.loginVisible=false;
        this.$router.go(0);
      },
      closere(){
        this.registerVisible=false;
        this.$router.go(0);
      }, 
      // closeco(){
      //   this.collectVisible=false;
      // }, 
      openCollect(){
        console.log('collect:'+this.collectVisible)
        if (this.collectVisible==false) {
          if (this.$store.state.account.length != 0) {
            this.collectVisible=true;
          }else{
            this.$message({type: 'error', message: '请先登录哦!', showClose: true})
            this.loginVisible=true;
            return;
          }
        }else{
          this.collectVisible=false;
        }
               
      },
      Getlikeandcollect(){
        let that=this
        if (that.$store.state.account.length != 0) {
            checkLike(that.article.id).then(data =>{
                that.islike=data.data
                
            }).catch(error => {
              if (error !== 'error') {
                that.$message({type: 'error', message: '点赞加载失败!', showClose: true})
              }
            })
            checkCollect(that.article.id).then(data =>{
                that.iscollect=data.data
                
            }).catch(error => {
              if (error !== 'error') {
                that.$message({type: 'error', message: '收藏加载失败!', showClose: true})
              }
            })             
        }   
      },
      testss(){
        console.log(123)
      },
      likes(){
        let that=this
        console.log('1')
        if (that.$store.state.account.length != 0) {
          if (that.islike) {
            cancelLike(that.article.id).then(data =>{
                that.islike=false
                that.likecounts=that.likecounts-1
                console.log(that.islike)
            }).catch(error => {
              if (error !== 'error') {
                that.$message({type: 'error', message: '取消点赞失败!', showClose: true})
              }
            }) 
          }else{
            addLike(that.article.id).then(data =>{
                that.islike=true
                that.likecounts=that.likecounts+1
                console.log(that.islike)
            }).catch(error => {
              if (error !== 'error') {
                that.$message({type: 'error', message: '点赞失败!', showClose: true})
              }
            })
          }
        }else{
          that.$message({type: 'error', message: '请先登录哦!', showClose: true})
          that.loginVisible=true;
        }
      }
    },

    components: {
      'login': Login,
      'register': Register,
      'collect': Collect
    }
  }
</script>

<style>
  .article-left-icon{
    width:100%;
    cursor: pointer;
    z-index:10;
  }

  .article-left {
    background-color: #fff;
    position: fixed;
    left: 100px;
    bottom: 50%;
    width: 40px;
    height: 120px;
    border-radius: 20px;
    
    transition: .3s;
    box-shadow: 0 0 6px rgba(0, 0, 0, .12);
    z-index: 5;
    text-align: center;
  }

  .article-left i {
    cursor: pointer;
    display: block;
    line-height: 40px;
    text-align: center; 
    font-size: 20px;
  }

</style>