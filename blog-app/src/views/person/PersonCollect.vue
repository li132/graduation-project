<template>
  <div id="collect">
    <div class="collect-body" v-if="collects && collects.length>0">
      <div class="me-collect" v-for="c in collects">
        <div class="collect-title" @click="collectDetil(c.collectId)">
          <font>{{c.title}}</font><br/>
          <font>{{c.createDate}}</font>
        </div>
        <div class="collect-buttom">
            <el-button type="danger" icon="el-icon-delete" circle @click="deleteCollects(c.collectId)"></el-button>
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
import { deleteCollect } from "@/api/article";

  export default {
    name:'PersonCollect',
    props:{
      userId:Number
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
        },
        collectDetil(collectId){
            this.$router.push({path: `/collectDetil/${collectId}`})
        },
        deleteCollects(collectId){
            let that=this 
            deleteCollect(collectId).then(data=>{
                that.$message({type: 'success', message: '收藏夹删除完成！', showClose: true})
                that.getCollects()
            }).catch(error => {
            if (error !== 'error') {
              console.log(error)
              that.$message({type: 'error', message: '收藏夹删除失败!', showClose: true})
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
  height:40px;
  line-height:40px;
}
.collect-button{
  float:right;
  width:50%;
}
.foot-input{
  float:left;
  width:60%;
},
.collect-left{
  float:left;
  width:100px;
  line-height:40px;
}
.collect-right{
    float:right;
}
</style>