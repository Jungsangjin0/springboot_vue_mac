<template>
    <div id="second">
        <input type="file" multiple @change="inFile">
        <button @click="save">데이터 저장하기</button>
    </div>
</template>

<script>
import axios from 'axios'
export default {
  data () {
    return {
      file: null
    }
  },
  methods: {
    inFile (event) {
      console.log(event)
      this.file = event.target.files[0]
    },
    save () {
      console.log('files:', this.file)
      let formData = new FormData()
      formData.append('files', this.file)
      axios.post('http://localhost:8080/upload', formData, {headers: {'Content-type': 'multipart/form-data'}}).then((res) => { console.log(res) }).catch((err) => { console.log(err) })
    }
  }
}
</script>
