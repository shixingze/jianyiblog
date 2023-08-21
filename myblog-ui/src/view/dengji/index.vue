<template>
 <el-form ref="data" :model="form" label-width="80px" style="margin-top: 200px;">
  <el-form-item label="姓名">
    <el-input v-model="data.userName"></el-input>
  </el-form-item>
  <el-form-item label="电话">
    <el-input v-model="data.phone"></el-input>
  </el-form-item>
  <el-form-item label="身份证号">
    <el-input v-model="data.idCard"></el-input>
  </el-form-item>
  <el-form-item label="体温">
    <el-input v-model="data.temperature"></el-input>
  </el-form-item>
  <el-form-item>
    <el-button type="primary" @click="add()">立即创建</el-button>
    <el-button>取消</el-button>
  </el-form-item>
</el-form>
</template>

<script>
export default {
  name: 'HelloWorld',
  data() {
      return {
        data: {
          userName: '',
          phone: '',
          idCard: '',
          temperature: ''
        }
      }
  },
  
    //在这里调用ajax请求方法
    created(){
      this.hotsix();
    },

  methods: {

    add() {
      this.$axios
        .post("/from/add", this.data)
        .then((successResponse) => {
          if (successResponse.data.code === 200) {
            alert(successResponse.data.msg);
            this.$router.push({
               name:"dengjiok"
           })
            // this.$notify({
            //   title: "成功",
            //   message: successResponse.data.msg,
            //   type: "success",
            // });
          }
        })
        .catch((failResponse) => {});
    },
  }
  
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
.musicbar {
  max-width: 80%;
  margin: 10px auto;
}
.card-body{
  max-height: 500px;
  min-height: 500px;
}
.card-body:hover{
  /* border: 1px solid darkgray; */
  box-shadow: 0 8px 16px 0 rgb(0 0 0 / 5%);
}
.card-body-title{
  text-overflow: -o-ellipsis-lastline;
overflow: hidden;
text-overflow: ellipsis;
display: -webkit-box;
-webkit-line-clamp: 2;
-webkit-box-orient: vertical;
}
.card-body-text{
  text-overflow: -o-ellipsis-lastline;
overflow: hidden;
text-overflow: ellipsis;
display: -webkit-box;
-webkit-line-clamp: 7;
-webkit-box-orient: vertical;
}
.card-body-icon{
  width: 82%;
  padding: 0 10px;
  margin: 0;
  position: absolute;
  bottom: 9px;
}
.card-body-icon span{
  /* margin-left: 60px; */
}
</style>
