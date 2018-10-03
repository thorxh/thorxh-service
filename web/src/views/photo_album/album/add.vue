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

          <el-form-item label="相册封面"
                        prop="cover">
            <el-upload
              class="avatar-uploader"
              action=""
              :show-file-list="false"
              :on-success="handleAvatarSuccess"
              :before-upload="beforeAvatarUpload">
              <img v-if="imageUrl" :src="imageUrl" class="avatar">
              <i v-else class="el-icon-plus avatar-uploader-icon"></i>
            </el-upload>
          </el-form-item>

        </el-form>
      </el-col>
    </el-row>
  </div>
</template>

<script>
export default {
  name: 'album',
  data () {
    return {
      albumAddModel: {
        name: '',
        cover: ''
      },
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
