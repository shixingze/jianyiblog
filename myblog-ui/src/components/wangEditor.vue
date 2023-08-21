<template>
    <div class='clearfix'>
        <!-- 富文本编辑框 -->
        <div id="wangEditorElem" style="height:210px;background: #ffffff;"></div>
    </div>
</template>

<script>
import E from 'wangeditor'
export default {
  name: 'text',
  data () {
    return {
      wEditor: '',
      name: ''
    }
  },
  props: {
    content: {
      type: String
    }
  }, 
  // 用来回显内容（监控父组件中content变化）
  watch:{
    content:function (newVal,oldVal) {
        this.wEditor.txt.html(newVal)
    }
  },
  methods: {
    //获取编辑器中内容
    getContent() {
      return this.wEditor.txt.html()
    },
    setContent() {
      this.wEditor.txt.html(this.content)
    },
    clearContent() {
      this.wEditor.txt.clear()
    },
  },

  mounted () {
    // wangeditor
    this.wEditor= new E('#wangEditorElem')
    // 上传图片到服务器，base64形式
    // this.wEditor.customConfig.uploadImgShowBase64 = true
    this.wEditor.customConfig.uploadFileName = 'file'
    this.wEditor.customConfig.uploadImgMaxSize = 5 * 1024 * 1024
    //上传文件个数
    this.wEditor.customConfig.uploadImgMaxLength = 1
    //绑定上传图片的后端地址
    this.wEditor.customConfig.uploadImgServer = this.$http.adornUrl(`/sys/file/upload?token=${this.$cookie.get('token')}`);
    // 隐藏网络图片
    this.wEditor.customConfig.showLinkImg = false
    this.wEditor.customConfig.menus = [
            'head',  // 标题
            'bold',  // 粗体
            'fontSize',  // 字号
            'fontName',  // 字体
            'italic',  // 斜体
            'underline',  // 下划线
            'foreColor',  // 文字颜色
            'quote',  // 引用
            'image',  // 插入图片
            'code',  // 插入代码
            'undo',  // 撤销
            'redo'  // 重复
    ];
    
    this.wEditor.customConfig.uploadImgHooks = {
        fail: function (xhr, editor, result) {
            this.$message('上传图片失败');
        },
        error: function (xhr, editor) {
            this.$message('上传图片出错');
        },
        timeout: function (xhr, editor) {
            this.$message('上传图片超时');
        },
		//自定义上传图片，回显图片
        customInsert: function (insertImg, result, editor) {
            var url = result.data[0]
            // window.serverUrl 是nginx图片服务器地址
            // url 是后台返回的上传图片的路径
            insertImg(window.serverUrl + url)
        }
    }
    // 创建一个富文本编辑器
    this.wEditor.create()
    // 富文本内容
    this.wEditor.txt.html(this.content)
  }
}
</script>
<style scoped>
.w-e-text-container {
    height: 160px !important;
}
</style>

