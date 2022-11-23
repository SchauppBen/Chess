<template>
    <section id="board">
        
    </section>
</template>

<script>
export default {
  name: 'Board',
  data() {
    return {
      board: []
    }
  },
  mounted() {
    fetch("/board")
      .then((response) => {
          return response.json()
      })
      .then((data) => {
          this.board = data;
      });
  }
}
</script>