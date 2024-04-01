extends Node3D

var current_gltf_node: Node3D = null

func _ready():
	_load_gltf("apple.glb")

func _process(delta) -> void:
	if current_gltf_node == null:
		return
		
	current_gltf_node.rotate_z(0.01)

func _load_gltf(gltf_path: String):
	if current_gltf_node != null:
		remove_child(current_gltf_node)
		
	current_gltf_node = load("res://"+gltf_path).instantiate()
	
	add_child(current_gltf_node)	
