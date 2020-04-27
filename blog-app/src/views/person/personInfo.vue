<template>
    <div id="personInfos">
        <div class="personInfo-all">
            <h2>个人资料</h2>
            <el-divider></el-divider>
            <div class="personInfo-form" ref="personInfo" :model="personInfo">
                <el-form label-position="left">
                    <el-form-item label="头像">
                        <img :src="this.$store.state.avatar"/>
                    </el-form-item>
                    <el-form-item label="用户名">
                        <el-input v-model="this.user.nickname"></el-input>
                    </el-form-item>
                    <el-form-item label="职位">
                        <el-input v-model="this.personInfo.position"></el-input>
                    </el-form-item>
                    <el-form-item label="公司">
                        <el-input v-model="this.personInfo.company"></el-input>
                    </el-form-item>
                    <el-form-item label="个人介绍">
                        <el-input v-model="this.personInfo.profile"></el-input>
                    </el-form-item>
                    <el-form-item label="个人主页">
                        <el-input v-model="this.personInfo.homepage"></el-input>
                    </el-form-item>
                    <el-form-item>
                        <el-button type="primary" @click="submitForm()">修改</el-button>
                    </el-form-item>
                </el-form>
            </div>
        </div>
    </div>
</template>

<script>
import { getUserInfos } from "@/api/login";
import { updateUserInfo } from "@/api/login";
import { getUserInfo } from "@/api/login";
import { getUserInfoById } from "@/api/login";

export default {
    name:"personInfo",
    data(){
        return {
            personInfo:{
                infoId:0,
                userId:0,
                position:'',
                company:'',
                profile:'',
                homepage:''
            },
           
            user:{
                id:0,
                avatar:'',
                email:'',
                mobilePhoneNumber:'',
                nickname:'',
                password:''
            }            
        }
    },
    rules: {
          name: [
            { required: true, message: '请输入活动名称', trigger: 'blur' },
            { min: 3, max: 5, message: '长度在 3 到 5 个字符', trigger: 'blur' }
          ]
        },
    created(){
        this.getUser()
        this.getUserInfoz()        
    },
    // mounted(){
    //     this.setUserInfos()
    // },
    methods:{
        getUserInfoz(){
            let that = this
            var keys = new Array()
            var keys2 = new Array()
            getUserInfos(that.$store.state.id).then(data=>{
                that.personInfo = data.data
                 keys=Object.keys(data.data)  
                console.log(data.data)
                console.log(that.personInfo)
            }).catch(error => {
            if (error !== 'error') {
                that.$message({type: 'error', message: '个人信息加载失败!', showClose: true})
            }
            })
        },
        getUser(){
            let that = this
            getUserInfoById(that.$store.state.id).then(data=>{
                that.user=data.data
            }).catch(error => {
            if (error !== 'error') {
                that.$message({type: 'error', message: '个人资料加载失败!', showClose: true})
            }
            })
        },
        submitForm(){
            let that = this
            console.log(that.personInfo)
            // updateUserInfo(that.user,that.getUserInfo).then(data=>{
            //     this.$router.go(0)
            // }).catch(error => {
            // if (error !== 'error') {
            //     that.$message({type: 'error', message: '修改个人资料失败!', showClose: true})
            // }
            // })
        }
    }
}
</script>