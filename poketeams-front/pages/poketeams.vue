<template>
  <v-row>
    <v-col class="text-center">
      <blockquote class="blockquote">
        <p v-for="team in teams" :key="team.id">
          {{ team.title }}
        </p>
      </blockquote>
    </v-col>
  </v-row>
</template>

<script>
import axios from 'axios'

export default {
  data() {
    return {
      teams: [],
    }
  },
  mounted() {
    axios.get('/api/teams').then((res) => (this.teams = res.data))
  },
}
</script>