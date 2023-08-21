
<template>
 <div style="margin-top: 200px;">
  <h2> 申请成功</h2></div>
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
  
    
  methods: {

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
