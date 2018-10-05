<template>
  <div>
    <el-row class="item_style">
      <el-col :span="10" :offset="7">
        <div class="album_name">
          {{ item.name }}
        </div>
        <div class="album_description">
          {{ item.description }}
        </div>
        <el-card :body-style="{ padding: '0px' }">
          <img :src="item.coverPath" class="image" v-on:click="showPhotos">
        </el-card>
        <div class="separator"></div>
      </el-col>
    </el-row>
  </div>
</template>

<script>
export default {
  props: {
    item: {
      type: Object,
      required: true
    }
  },
  methods: {
    showPhotos () {
      this.$emit('showPhotos', this.item.id)
    }
  }
}
</script>

<style scoped>
  .item_style {
    margin-top: 10px;
    margin-bottom: 20px;
  }
  .image {
    width: 100%;
    display: block;
  }
  .album_name {
    font-family: "Microsoft JhengHei UI", sans-serif;
    font-size: 20px;
    width: 100%;
    margin: 5px;
  }
  .album_description {
    font-family: "Microsoft JhengHei UI", sans-serif;
    font-size: 15px;
    width: 100%;
    margin: 10px 10px 5px 5px;
  }
  .separator {
    width: 100%;
    height: 1px;
    margin: 20px auto 0;
    padding: 0;
    background-color: #D5D5D5;
    overflow: hidden;
  }
</style>
