import http from "../http-common";

class FlightCrewAssignmentService {
  getAllFlightCrewAssignments(searchDTO) {
    console.log(searchDTO)
    return this.getRequest(`/flightCrewAssignment/flightCrewAssignments`, searchDTO);
  }

  get(flightCrewAssignmentId) {
    return this.getRequest(`/flightCrewAssignment/${flightCrewAssignmentId}`, null);
  }

  findByField(matchData) {
    return this.getRequest(`/flightCrewAssignment?field=${matchData}`, null);
  }

  addFlightCrewAssignment(data) {
    return http.post("/flightCrewAssignment/addFlightCrewAssignment", data);
  }

  update(data) {
  	return http.post("/flightCrewAssignment/updateFlightCrewAssignment", data);
  }
  
  uploadImage(data,flightCrewAssignmentId) {
  	return http.postForm("/flightCrewAssignment/uploadImage/"+flightCrewAssignmentId, data);
  }




	postRequest(url, data) {
		return http.post(url, data);
      };

	getRequest(url, params) {
        return http.get(url, {
        	params: params
        });
    };

}

export default new FlightCrewAssignmentService();
