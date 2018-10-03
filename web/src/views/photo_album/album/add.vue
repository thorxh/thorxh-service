<!--suppress ALL -->
<template>
  <div class="app-container">
    <el-row>
      <el-col :span="8"
              :offset="8">
        <el-form class="small-space"
                 label-position="left"
                 :model="albumAddModel"
                 ref="addAlbumForm"
                 label-width="80px" style="margin-left:10px; margin-right:10px;"
                 status-icon>

          <el-form-item
            label="相册名称"
            prop="name">
            <el-input type="text"
                      auto-complete="off"
                      clearable
                      v-model="albumAddModel.name">
            </el-input>
          </el-form-item>

          <el-form-item
            label="相册封面"
            prop="name">
            <el-upload
              ref="upload"
              class="avatar-uploader"
              action="//127.0.0.1:7210/pa/file/uploadCover"
              :show-file-list="false"
              :on-success="handleAvatarSuccess"
              :before-upload="beforeAvatarUpload">
              <img v-if="imageUrl" :src="imageUrl" class="avatar">
              <i v-else class="el-icon-plus avatar-uploader-icon"></i>
            </el-upload>
          </el-form-item>

          <el-form-item
            label="相册描述"
            prop="description">
            <el-input type="text"
                      auto-complete="off"
                      clearable
                      v-model="albumAddModel.description">
            </el-input>
          </el-form-item>

          <el-form-item>
            <el-button type="primary" @click="createAlbum">创建</el-button>
          </el-form-item>
        </el-form>
      </el-col>
    </el-row>
  </div>
</template>

<script>

import { createAlbum } from '@/api/album'

export default {
  data () {
    return {
      albumAddModel: {
        name: '',
        coverPath: '',
        description: ''
      },
      imageUrl: ''
    }
  },
  methods: {
    /**
     * 添加相册
     */
    createAlbum () {
      createAlbum(this.albumAddModel).then(response => {
        if (response.data.success) {
          this.$message.success('创建相册成功')
          this.imageUrl = ''
          this.$refs.upload.clearFiles()
          this.$refs.addAlbumForm.resetFields()
        } else {
          this.$message.error('创建相册失败，请稍后重试')
        }
      }).catch(() => {
        this.$message.error('创建相册失败，请稍后再试。')
      })
    },
    /**
     * 封面上传成功后的操作
     */
    handleAvatarSuccess (res, file) {
      this.albumAddModel.coverPath = res.data
      this.imageUrl = URL.createObjectURL(file.raw)
    },
    /**
     * 封面上传之前的检验
     */
    beforeAvatarUpload (file) {
      const isJPG = file.type === 'image/jpeg' || file.type === 'image/png'
      const isLt2M = file.size / 1024 / 1024 < 2

      if (!isJPG) {
        this.$message.error('上传头像图片只能是 JPG 格式!')
      }
      if (!isLt2M) {
        this.$message.error('上传头像图片大小不能超过 2MB!')
      }
      return isJPG && isLt2M
    }
  }
}

</script>

<style scoped>
  .avatar-uploader .el-upload {
    border: 1px dashed #d9d9d9;
    border-radius: 6px;
    cursor: pointer;
    position: relative;
    overflow: hidden;
  }
  .avatar-uploader .el-upload:hover {
    border-color: #409EFF;
  }
  .avatar-uploader-icon {
    font-size: 28px;
    color: #8c939d;
    width: 178px;
    height: 178px;
    line-height: 178px;
    text-align: center;
  }
  .avatar {
    width: 178px;
    height: 178px;
    display: block;
  }
</style>
