extends CharacterBody2D


const SPEED = 150.0
const JUMP_VELOCITY = -300.0

var gravity = ProjectSettings.get_setting("physics/2d/default_gravity")


func _physics_process(delta):

	if not is_on_floor():
		velocity.y += gravity * delta
		$animation.play("falling")
	
	if is_on_floor() and velocity.x == 0 and not Input.is_action_pressed("ui_down"):
		$animation.play("idle")
		
	if Input.is_action_just_pressed("ui_accept") and is_on_floor():
		velocity.y = JUMP_VELOCITY 
		$animation.play("jumping")

	#double jump
	if Input.is_action_just_pressed("ui_accept") and not is_on_floor():
		velocity.y = JUMP_VELOCITY/2
		$animation.play("double_jump")
	
	var direction = Input.get_axis("ui_left", "ui_right")

	if direction:
		velocity.x = direction * SPEED
		$animation.play("walk")
		$animation.flip_h = direction < 0
	else:
		velocity.x = move_toward(velocity.x, 0, SPEED)
		
	if Input.is_action_pressed("ui_down") and not direction:
		$animation.play("wiggle")

	move_and_slide()



