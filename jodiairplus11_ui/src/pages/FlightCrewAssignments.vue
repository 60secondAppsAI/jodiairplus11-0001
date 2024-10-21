<template>
  <div class="content">
    <div class="row">
      <div class="col-12">
        <card class="card-plain">
          <!-- <template slot="header">
            <h4 class="card-title">Table on Plain Background</h4>
            <p class="category">Here is a subtitle for this table</p>
          </template>-->
          <div class="table-full-width text-left">
            <flightCrewAssignment-table
            v-if="flightCrewAssignments && flightCrewAssignments.length > 0"
				:title="table1.title"
				:sub-title="table1.subTitle"
				:flightCrewAssignments="flightCrewAssignments"
				:totalElements="totalElements"
				:page="page"
				:columns="table1.columns"
 				@get-all-flight-crew-assignments="getAllFlightCrewAssignments"
             >

            </flightCrewAssignment-table>
          </div>
        </card>
      </div>

    </div>
  </div>
</template>
<script>
import { Card } from "@/components/index";

import FlightCrewAssignmentTable from "@/components/FlightCrewAssignmentTable";
import FlightCrewAssignmentService from "../services/FlightCrewAssignmentService";

const tableColumns = [];
const tableData = [
];

export default {
  components: {
    Card,
    FlightCrewAssignmentTable,
  },
  data() {
    return {
      flightCrewAssignments: [],
	  totalElements: 0,
      page: 0,
      searchQuery: '',     
      table1: {
        title: "Simple Table",
        columns: [...tableColumns],
        data: [...tableData],
      },
    };
  },
  methods: {
    async getAllFlightCrewAssignments(sortBy='flightCrewAssignmentId',sortOrder='true',page="0",size="50") {
      try {
        try {
			const searchDTO = {
				sortBy: sortBy, 
				sortOrder: sortOrder, 
				searchQuery: this.searchQuery,
				page: page, 
				size: size
			};
	        let response = await FlightCrewAssignmentService.getAllFlightCrewAssignments(searchDTO);
	        if (!response.data.empty) {
		        if (response.data.flightCrewAssignments.length) {
					this.flightCrewAssignments = response.data.flightCrewAssignments;
				}
      			this.totalElements = response.data.totalElements;
      			this.page = response.data.page;
	        }
        } catch (error) {
          console.error("Error fetching flightCrewAssignments:", error);
        }
        
      } catch (error) {
        console.error("Error fetching flightCrewAssignment details:", error);
      }
    },
  },
  mounted() {
    this.getAllFlightCrewAssignments();
  },
  created() {
    this.$root.$on('searchQueryForFlightCrewAssignmentsChanged', (searchQuery) => {
    	this.searchQuery = searchQuery;
    	this.getAllFlightCrewAssignments();
    })
  }
};
</script>
<style></style>
