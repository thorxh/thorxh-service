<template>
  <div id="album_list">
    <albumItem
      v-for="(album, index) in albums"
      :key="index"
      :album="album">
    </albumItem>
  </div>
</template>

<script>

import { query } from '@/api/album'
import albumItem from '@/views/photo_album/album/item'

export default {
  components: {
    albumItem
  },
  created () {
    this.getAlbums()
  },
  data () {
    return {
      albums: []
    }
  },
  methods: {
    getAlbums () {
      query().then(res => {
        if (res.success) {
          this.albums = res.data.list
        } else {
          this.$message.error('查询失败，请稍后重试')
        }
      }).catch(() => {
        this.$message.error('查询失败，请稍后重试')
      })
    }
  }
}
</script>

<style scoped>

</style>
