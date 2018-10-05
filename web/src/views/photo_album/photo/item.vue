<template>
  <div id="photo-item">
    <el-row class="item_style">
      <el-col :span="10" :offset="7">
        <el-card :body-style="{ padding: '0px' }">
          <!--<viewer-->
            <!--:options="options"-->
          <!--&gt;-->
            <img :src="item.imagePath + '?' + item.imageStyle" :data-source="item.imagePath" class="image">
          <!--</viewer>-->
        </el-card>
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
  data () {
    return {
      options: {
        button: true,
        navbar: true,
        title: true,
        toolbar: true,
        tooltip: true,
        movable: true,
        zoomable: true,
        rotatable: true,
        scalable: true,
        transition: true,
        fullscreen: true,
        keyboard: true,
        url: 'data-source'
      }
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
</style>
