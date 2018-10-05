<template>
  <div id="photo-add">
    <el-upload
      :action="uploadURL"
      list-type="picture-card"
      :data="param"
      :before-upload="handleBeforeUpload"
      :on-preview="handlePictureCardPreview"
      :on-remove="handleRemove">
      <i class="el-icon-plus"></i>
    </el-upload>
    <el-dialog :visible.sync="dialogVisible">
      <img width="100%" :src="dialogImageUrl" alt="">
    </el-dialog>
  </div>
</template>

<script>
// import {  } from '@/api/photo'

export default {
  data () {
    return {
      dialogImageUrl: '',
      dialogVisible: false,
      uploadURL: process.env.BASE_API + '/photo',
      param: {
        albumId: 1
      }
    }
  },
  methods: {
    handleBeforeUpload (file) {
    },
    handleRemove (file, fileList) {
    },
    handlePictureCardPreview (file) {
      this.dialogImageUrl = file.url
      this.dialogVisible = true
    }
  }
}
</script>

<style scoped>

</style>
