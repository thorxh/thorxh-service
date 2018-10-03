<template>
  <div class="app-container">
    <router-link
      to='/photo_album/add'>
      add
    </router-link>
    <router-view></router-view>
  </div>
</template>

<script>
export default {
  methods: {
    jump () {
      this.$message.success('yes')
    }
  }
}
</script>

<style scoped>

</style>
