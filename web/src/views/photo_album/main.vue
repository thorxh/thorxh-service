<template>
  <div class="app-container">
    <router-link
      to='/photo_album/add'>
      add
    </router-link>
    <router-link
      to='/photo_album/list'>
      list
    </router-link>
    <router-view></router-view>
  </div>
</template>

<script>
export default {
}
</script>

<style scoped>

</style>
