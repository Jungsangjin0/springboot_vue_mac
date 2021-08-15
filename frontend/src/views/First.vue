<template>
    <div id="first">
        <ul>
            <li v-for="(item, index) in list" :key=index>
               {{ item.id}} // {{ item.title }} // {{ item.content }} // {{ item.date }}
            </li>
        </ul>
    </div>
</template>

<script>
import axios from 'axios'
export default {
  name: 'first',
  data () {
    return {
      list: null
    }
  },
  created () {
    axios.get('http://localhost:8080/test')
      .then((res) => {
        this.list = res.data
      }).catch((err) => {
        console.log(err)
      })
  }
}
</script>
