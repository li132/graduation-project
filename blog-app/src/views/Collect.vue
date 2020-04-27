<template>
  <div id="collect">
    <div class="collect-body" v-if="collects && collects.length>0">
      <div class="me-collect" v-for="c in collects">
        <div v-if="!isInCollect(c)">
          <div class="collect-title"><font>{{c.title}}</font></div>
          <div class="collect-button"><el-button @click="addsCollect(c.collectId)" type="primary">添加至收藏夹</el-button></div>         
        </div>
        <div v-else>
          <div class="collect-title"><font>{{c.title}}</font></div>
          <div class="collect-button"><el-button @click="cancelsCollect(c.collectId)" type="info">从收藏夹删除</el-button></div>
        </div>                   
      </div>
    </div>
    <div v-else>
      <font>创建收藏夹，开始学习吧！</font>
    </div>
    <div class="collect-foot">
      <div class="foot-input"><el-input placeholder="请输入收藏集名称" v-model="input" clearable></el-input></div>
      <div><el-button icon="el-icon-circle-plus-outline" @click="newCollectss()"></el-button></div>           
    </div>
  </div>
</template>

<script>
import { getCollect } from '@/api/article';
import { addCollect } from "@/api/article";
import { newCollects } from "@/api/article";
import { cancelCollect } from "@/api/article";

  export default {
    name:'Collect',
    props:{
      articleId:Number
    },
    data(){
      return{
        collects:[],
        input:''
      }
    },

    created(){
      this.getCollects()
    },
    methods:{        
        getCollects(){
            let that = this
            getCollect().then(data => {
                that.collects=data.data
            }).catch(error => {
            if (error !== 'error') {
            console.log(error)
            that.$message({type: 'error', message: '收藏夹加载失败!', showClose: true})
            }
            })
        },
        isInCollect(c){
          console.log('collectId:'+c.collectId)
          console.log('articleId:'+this.articleId)
          let result = -1;
          c.articles.forEach((i,index)=>{
            if(i.id == this.articleId){
              result = index
              console.log('result:'+result)
              return false;
            }
          })
          console.log(result)
          return result > -1;
        },
        addsCollect(collectId){
          let that=this
          console.log(collectId)
          addCollect(collectId,that.articleId).then(data=>{
            that.$message({type: 'success', message: '收藏成功！', showClose: true})
            that.getCollects()
          }).catch(error => {
            if (error !== 'error') {
              console.log(error)
              that.$message({type: 'error', message: '收藏失败!', showClose: true})
            }
          })
        },
        cancelsCollect(collectId){
          let that=this
          console.log(collectId)
          cancelCollect(collectId,that.articleId).then(data=>{
            that.$message({type: 'success', message: '取消收藏成功！', showClose: true})
            that.getCollects()
          }).catch(error => {
            if (error !== 'error') {
              console.log(error)
              that.$message({type: 'error', message: '取消收藏失败!', showClose: true})
            }
          })
        },
        newCollectss(){
          let that=this          
          newCollects(that.input).then(data=>{
            that.$message({type: 'success', message: '新建收藏集收藏成功！', showClose: true})
            that.getCollects()
            that.input=''
          }).catch(error => {
            if (error !== 'error') {
              console.log(error)
              that.$message({type: 'error', message: '新建收藏集失败!', showClose: true})
            }
          })
        }
    }
  }
</script>

<style>
.el-dialog__body {
  border-top: 1px solid #ddd;
  padding-top:0px;
}
.me-collect{
  border-bottom: 1px solid #ddd;
  height:50px;
  clear:both;
  margin-top:10px;
}
.collect-title{
  float:left;
  width:50%;
  line-height:40px;
}
.collect-button{
  float:right;
  width:50%;
}
.foot-input{
  float:left;
  width:70%;
}
</style>