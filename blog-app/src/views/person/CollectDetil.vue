<template>
<div id="collectDetil">
    <div class="detil-all">
        <div class="detil-head">{{this.collect.title}}</div>
        <div class="collect-articles">
            <article-scroll-page  v-bind="article" v-if="this.article.title!=''"></article-scroll-page>
        </div>
    </div>
</div>
</template>

<script>
import ArticleScrollPage from '@/views/common/ArticleScrollPage'
import { getOneCollect } from "@/api/article";
    export default {
        name:'collectDetil',
        data(){
          return{
            article: {
              query: {
                collectId:this.$route.params.collectId
              },
              title:''
            },
            collectId:this.$route.params.collectId,
            collect: {}
          }
        },
        created(){
            this.getCollect();
        },
        methods:{
            getCollect(){
                let that = this
                getOneCollect(that.collectId).then(data=>{
                    that.collect=data.data
                    that.article.title= that.collect.title
                    console.log(that.collect)
                }).catch(error => {
                if (error !== 'error') {
                  console.log(error)
                  that.$message({type: 'error', message: '获取收藏集信息失败!', showClose: true})
                }
          })
            }
        },
        components: {
          ArticleScrollPage
        }
    }
</script>
    
<style>
</style>