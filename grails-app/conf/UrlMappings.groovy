class UrlMappings {

	static mappings = {
        "/$controller/$action?/$id?" {}
		"/"(controller: "Books")
        "500"(view:'/error')
	}
}
