<template>
  <div id="photo-list" >
    <div v-viewer="{url: 'data-source', scalable: false, title: false, button: true}">
      <photoItem
        v-for="photo in photos"
        :key="photo.id"
        :item="photo"
      >
      </photoItem>
    </div>
  </div>
</template>

<script>
import photoItem from '@/views/photo_album/photo/item'
import { query } from '@/api/photo'

export default {
  components: {
    photoItem
  },
  created () {
    this.queryParams.albumId = this.$route.params.albumId
    this.getPhoto()
  },
  data () {
    return {
      photos: [],
      imageList: [],
      queryParams: {
        albumId: ''
      }
    }
  },
  methods: {
    getPhoto () {
      query(this.queryParams).then(res => {
        if (res.success) {
          this.photos = res.data.list
          this.photos.forEach(value => {
            this.imageList.push({
              width: value.imageWidth,
              height: value.imageHeight,
              url: value.imagePath
            })
          })
        } else {
          this.$message.error(res.message)
        }
      }).catch(() => {
        this.$message.error('获取图片失败，请稍后再试')
      })
    }
  }
}
</script>

<style scoped>

</style>
