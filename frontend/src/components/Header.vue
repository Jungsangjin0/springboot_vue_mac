<template>
   <div id="header">
       <nav>
         <label class="logo">Design</label>
    <ul>
        <li><router-link :to="{name: 'HelloWorld'}">home</router-link></li>
        <li><router-link :to="{name: 'first'}">first</router-link></li>
        <li><router-link :to="{name: 'second'}">second</router-link></li>
        <li><router-link :to="{name: 'third'}">third</router-link></li>
        <li><div  @click="test">fourth</div></li>
    </ul>
    </nav>
   </div>
</template>

<script>
export default {
  id: '#header',
  components: {
    Header: this
  },
  data () {
    return {
      testData: 'test Header'
    }
  },
  methods: {
    test () {
      this.$router.push('fourth')
    }
  }
}
</script>
<style scoped>
    *{
            padding: 0;
            margin: 0;
            text-decoration: none;
            list-style: none;
            box-sizing: border-box;
        }
        body{
            font-family: montserrat;
        }
        nav{
            background: #0082e6;
            height: 80px;
            width: 100%;
        }
        label.logo{
            color: white;
            font-size: 35px;
            line-height: 80px;
            padding:0px 100px;
            font-weight: bold;
        }
        nav ul{
            float: right;
            margin-right: 20px;
        }
        nav ul li {
            display: inline-block;
            line-height: 80px;
            margin: 0 5px;
        }
        nav ul li a {
            color: white;
            font-size: 17px;
            text-transform: uppercase;
            padding: 7px 13px;
            border-radius: 3px;
        }
        a.active,a:hover{
            background: #1b9bff;
            transition: .5s;

        }

</style>
