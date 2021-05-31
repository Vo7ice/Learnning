<template>
  <li class="item" @click="handleClick">{{content}} {{index}}</li>
</template>

<script>
export default {
  props: [ 'content', 'index'],
  methods: {
    handleClick() {
      console.log("handleClick")
      this.$emit('delete', this.index)
    }
  },
 
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
  .item {
    color:blue
  }
</style>
