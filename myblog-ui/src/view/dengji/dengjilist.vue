<template>
 <div style="margin-top: 100px;">
  <h1>登记记录</h1>
  <el-table
    :data="tableData"
    stripe
    style="width: 100%">
    <el-table-column
      prop="userName"
      label="名称"
      width="180">
    </el-table-column>
    <el-table-column
      prop="phone"
      label="电话"
      width="180">
    </el-table-column>
    <el-table-column
      prop="idCard"
      label="身份证号">
    </el-table-column>
    <el-table-column
      prop="temperature"
      label="温度">
    </el-table-column>
    <el-table-column
      prop="createTime"
      label="到访时间">
    </el-table-column>
  </el-table>
 </div>
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
          temperature: '',
          
          
        },
        tableData:[{
          date: '2016-05-02',
          name: '王小虎',
          address: '上海市普陀区金沙江路 1518 弄'
        }, {
          date: '2016-05-04',
          name: '王小虎',
          address: '上海市普陀区金沙江路 1517 弄'
        }, {
          date: '2016-05-01',
          name: '王小虎',
          address: '上海市普陀区金沙江路 1519 弄'
        }, {
          date: '2016-05-03',
          name: '王小虎',
          address: '上海市普陀区金沙江路 1516 弄'
        }]
      }
  },
  
    //在这里调用ajax请求方法
    created(){
      this.list();
    },

  methods: {
    list() {
      this.$axios
        .post("/from/list", this.data)
        .then((successResponse) => {
          if (successResponse.data.code === 200) {
            console.log(successResponse.data.data);
            this.tableData = successResponse.data.data;
            console.log(this.tableData);
            // this.$notify({
            //   title: "成功",
            //   message: successResponse.data.msg,
            //   type: "success",
            // });
          }
        })
        .catch((failResponse) => {});
      },
    add() {
      this.$axios
        .post("/from/add", this.data)
        .then((successResponse) => {
          if (successResponse.data.code === 200) {
            alert(successResponse.data.msg)
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
</style>
