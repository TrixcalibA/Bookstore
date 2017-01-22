class UrlMappings {

	static mappings = {
        "/$controller/$action?/$id?" {}
		"/"(controller: "SearchBooks")
        "500"(view:'/error')
	}
}
