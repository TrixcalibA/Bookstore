class UrlMappings {

	static mappings = {
        "/$controller/$action?/$id?" {}
		"/"(controller: "OurBooks")
        "500"(view:'/error')
	}
}
