<template>
  <el-header class="me-area">
    <el-row class="me-header">

      <el-col :span="4" class="me-header-left">
        <router-link to="/" class="me-title">
          <img src="../assets/img/logo.png"/>
        </router-link>
      </el-col>

      <el-col v-if="!simple" :span="16">
        <el-menu :router=true menu-trigger="click" active-text-color="#5FB878" :default-active="activeIndex"
                 mode="horizontal">
          <el-menu-item index="/">首页</el-menu-item>
          <el-menu-item index="/category/all">文章分类</el-menu-item>
          <el-menu-item index="/tag/all">标签</el-menu-item>
          <el-menu-item index="/archives">文章归档</el-menu-item>
          <el-input v-model="word" placeholder="请输入内容" class="search"></el-input>
          <el-button type="primary" @click="Search">搜索</el-button>
          <el-col :span="4" :offset="4">
            <el-menu-item index="/write"><i class="el-icon-edit"></i>写文章</el-menu-item>
          </el-col>

        </el-menu>
      </el-col>
      
      <template v-else>
        <slot></slot>
      </template>
      
      <el-col :span="4">
        <el-menu :router=true menu-trigger="click" mode="horizontal" active-text-color="#5FB878">

          <template v-if="!user.login">
            <!-- <el-menu-item index="/login">
              <el-button type="text">登录</el-button>
            </el-menu-item> -->
            <el-menu-item>
              <el-button type="text" round @click="logins()">登录</el-button>
            </el-menu-item>             
            <el-menu-item >
              <el-button type="text" round @click="register()">注册</el-button>
            </el-menu-item>
            <el-dialog :visible.sync="loginVisible" center :append-to-body='true' :lock-scroll="false" width="360px">
              <login @closeLogin="closelg()" @toRegister="toRegisters($event)"></login>
            </el-dialog>
            <el-dialog :visible.sync="registerVisible" center :append-to-body='true' :lock-scroll="false" width="360px">
              <register @closeRegister="closere()" @toLogin="toLogins($event)"></register>
            </el-dialog>
          </template>

          <template v-else>
            <el-submenu index>
              <template slot="title">
                <img class="me-header-picture" :src="user.avatar"/>
              </template>
              <el-menu-item index="/person"><i class="el-icon-user"></i>个人中心</el-menu-item>
              <el-menu-item index @click="logout"><i class="el-icon-back"></i>退出</el-menu-item>
            </el-submenu>
          </template>
        </el-menu>
      </el-col>

    </el-row>
  </el-header>
</template>

<script>
import Login from '@/views/Login'
import Register from '@/views/Register'

  export default {

    name: 'BaseHeader',
    props: {
      activeIndex: String,
      simple: {
        type: Boolean,
        default: false
      }
    },
    data() {
      return {
        word: "",
        loginVisible: false,
        registerVisible: false
      }
    },
    computed: {
      user() {
        let login = this.$store.state.account.length != 0
        let avatar = this.$store.state.avatar
        return {
          login, avatar
        }
      }
    },
    methods: {
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
      logout() {
        let that = this
        this.$store.dispatch('logout').then(() => {
          this.$router.push({path: '/'})
        }).catch((error) => {
          if (error !== 'error') {
            that.$message({message: error, type: 'error', showClose: true});
          }
        })
      },
      Search(){
        var word = this.word;
        this.$router.push("/search/"+word)
      },
      closelg(){
        this.loginVisible=false;
        this.$router.go(0);
      },
      logins(){
        this.loginVisible=true
      },
      closere(){
        this.registerVisible=false;
        this.$router.go(0);
      },
      register(){
        this.registerVisible=true
      },
    },
    components: {
      'login': Login,
      'register': Register
    }

  }
</script>

<style>
  .search{
    width: 200px;
    margin-top: 10px;
  }

  .el-header {
    position: fixed;
    z-index: 1024;
    min-width: 100%;
    box-shadow: 0 2px 3px hsla(0, 0%, 7%, .1), 0 0 0 1px hsla(0, 0%, 7%, .1);
  }

  .me-title {
    margin-top: 10px;
    font-size: 24px;
  }

  .me-header-left {
    margin-top: 10px;
  }

  .me-title img {
    max-height: 2.4rem;
    max-width: 100%;
  }

  .me-header-picture {
    width: 36px;
    height: 36px;
    border: 1px solid #ddd;
    border-radius: 50%;
    vertical-align: middle;
    background-color: #5fb878;
  }
</style>
